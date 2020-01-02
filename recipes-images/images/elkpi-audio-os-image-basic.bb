SUMMARY = "Image for Elk Pi which contains basic packages"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

require recipes-core/images/core-image-minimal.bb
require elkpi-common.inc

EXTRA_IMAGE_FEATURES += " ssh-server-openssh package-management"

IMAGE_ROOTFS_SIZE = "1000000"
SDIMG_ROOTFS_TYPE = "ext4"
IMAGE_FSTYPES = "wic ext4.gz"
NOISO = "0"
NOHDD = "1"
WKS_FILE = "elkpi.wks"

# To make the image read only, uncomment the following line
#IMAGE_FEATURES += "read-only-rootfs"
