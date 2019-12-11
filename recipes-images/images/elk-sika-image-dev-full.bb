DESCRIPTION = "Elk Linux development image for Sika"

LICENSE = "GPLv2"
require recipes-core/images/core-image-minimal-dev.bb
require elk-sika-common.inc
inherit populate_sdk_qt5

IMAGE_INSTALL += " \
                  packagegroup-elk-devtools-extended \
                  packagegroup-elk-devtools-basic \
                  packagegroup-elk-python-basic \
                  packagegroup-elk-python-extended \
                  packagegroup-elk-audio-extra \
                  packagegroup-elk-sika-apps-extended \
                  packagegroup-elk-system-extended \
                  packagegroup-elk-libs-extended \
                  packagegroup-elk-qt-pkgs \
                  mda-vst2-plugins \
                  mda-vst3-plugins"

EXTRA_IMAGE_FEATURES += " ssh-server-openssh package-management"
IMAGE_ROOTFS_SIZE = "2000000"
SDIMG_ROOTFS_TYPE = "ext4"
IMAGE_FSTYPES = "wic ext4.gz"
NOISO = "0"
NOHDD = "1"
WKS_FILE = "sika.wks"