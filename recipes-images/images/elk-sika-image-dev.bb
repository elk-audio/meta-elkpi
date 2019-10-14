DESCRIPTION = "Elk Linux development image for Sika"

LICENSE = "GPLv2"
require recipes-core/images/core-image-minimal-dev.bb
require elk-sika-common.inc
#inherit populate_sdk_qt5
# packagegroup-elk-clang-dev-pkgs
# packagegroup-elk-qt-pkgs

IMAGE_INSTALL += "packagegroup-elk-devtools \
                  packagegroup-elk-python-pkgs \
                  packagegroup-elk-audio-extra \
                  mda-vst2-plugins \
                  mda-vst3-plugins"

EXTRA_IMAGE_FEATURES += " ssh-server-openssh package-management"
IMAGE_ROOTFS_SIZE = "4000000"
SDIMG_ROOTFS_TYPE = "ext4"
IMAGE_FSTYPES = "wic.bz2"
NOISO = "0"
NOHDD = "1"
WKS_FILE = "sika.wks"

ROOTFS_POSTPROCESS_COMMAND += "set_sudo_permissions; "

set_sudo_permissions () {
    # Give sudo permission for users
    sed -i 's/# %sudo/%sudo/' ${IMAGE_ROOTFS}/etc/sudoers
}
