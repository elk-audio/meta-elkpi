SUMMARY = "Image for Elk Pi which contains basic packages"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

require recipes-core/images/core-image-minimal.bb
require elkpi-common.inc

EXTRA_IMAGE_FEATURES += " ssh-server-openssh package-management"

IMAGE_ROOTFS_SIZE = "1000000"
SDIMG_ROOTFS_TYPE = "ext4"
IMAGE_FSTYPES = "wic ext4.gz"
WKS_FILE = "elkpi.wks"
