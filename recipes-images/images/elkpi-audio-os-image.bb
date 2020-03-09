SUMMARY = "Full development image for Elk Pi which contains all packages"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

require recipes-core/images/core-image-minimal-dev.bb
require elkpi-common.inc

IMAGE_INSTALL += "\
    packagegroup-elk-devtools-extended \
    packagegroup-elk-devtools-basic \
    packagegroup-elk-python-basic \
    packagegroup-elk-python-extended \
    packagegroup-elk-audio-extra \
    packagegroup-elkpi-apps-extended \
    packagegroup-elk-system-extended \
    packagegroup-elk-libs-extended \
    mda-vst3-plugins \
    mda-lv2 \
"

# Add mda-vst2-plugins to the image if VST2SDK_PATH is defined in local.conf
IMAGE_INSTALL += "${@bb.utils.contains('VST2SDK_PATH', \
                 '', \
                 ' mda-vst2-plugins ', \
                 ' ' \
                 , d)}"

EXTRA_IMAGE_FEATURES += " ssh-server-openssh package-management"
IMAGE_ROOTFS_SIZE = "2000000"
SDIMG_ROOTFS_TYPE = "ext4"
IMAGE_FSTYPES = "wic ext4.gz"
NOISO = "0"
NOHDD = "1"
WKS_FILE = "elkpi.wks"

# To make the image read only, uncomment the following line
#IMAGE_FEATURES += "read-only-rootfs"