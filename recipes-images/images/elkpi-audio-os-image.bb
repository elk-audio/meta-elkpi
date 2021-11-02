SUMMARY = "Full development image for Elk Pi which contains all packages"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

require recipes-core/images/core-image-minimal-dev.bb
require elkpi-common.inc

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += "\
    glibc-utils \
    localedef \
    packagegroup-elk-applications \
    packagegroup-elk-devtools-extended \
    packagegroup-elk-devtools-basic \
    packagegroup-elk-python-basic \
    packagegroup-elk-python-extended \
    packagegroup-elk-audio-extra \
    packagegroup-elkpi-apps-extended \
    packagegroup-elk-system-extended \
    packagegroup-elkpi-system-extended-pkgs \
    packagegroup-elk-libs-extended \
    mda-vst3-plugins \
    mda-lv2 \
"
# set sudo permisions fr mind user.
set_sudo_permissions () {
    # Give sudo permission for users
    sed -i 's/# %sudo/%sudo/' ${IMAGE_ROOTFS}/etc/sudoers
}

ROOTFS_POSTPROCESS_COMMAND += "set_sudo_permissions; "

# Add mda-vst2-plugins to the image if VST2SDK_PATH is defined in local.conf
IMAGE_INSTALL += "${@bb.utils.contains('VST2SDK_PATH', \
                 '', \
                 ' mda-vst2-plugins ', \
                 ' ' \
                 , d)}"

EXTRA_IMAGE_FEATURES = " debug-tweaks ssh-server-openssh package-management"
IMAGE_ROOTFS_SIZE = "2000000"
SDIMG_ROOTFS_TYPE = "ext4"
IMAGE_FSTYPES = "wic ext4.gz"
NOISO = "0"
NOHDD = "1"
WKS_FILE = "elkpi.wks"

# To make the image read only, uncomment the following line
#IMAGE_FEATURES += "read-only-rootfs"
