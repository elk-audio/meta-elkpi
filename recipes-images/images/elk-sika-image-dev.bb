DESCRIPTION = "Elk Linux development image for Sika"

LICENSE = "GPLv2"
require recipes-core/images/core-image-minimal-dev.bb
require elk-sika-common.inc
inherit populate_sdk_qt5

IMAGE_INSTALL += "packagegroup-elk-devtools \
                  packagegroup-elk-python-pkgs \
                  packagegroup-elk-clang-dev-pkgs \
                  packagegroup-elk-qt-pkgs \
                  mda-vst2-plugins \
                  mda-vst3-plugins"

EXTRA_IMAGE_FEATURES += " ssh-server-openssh package-management"
IMAGE_ROOTFS_SIZE = "3000000"
IMAGE_FSTYPES = "rpi-sdimg.bz2"
NOISO = "0"
NOHDD = "1"