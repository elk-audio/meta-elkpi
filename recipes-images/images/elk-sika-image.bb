DESCRIPTION = "Elk Linux production image for Sika"

LICENSE = "GPLv2"

require recipes-core/images/core-image-minimal.bb
require elk-sika-common.inc

IMAGE_ROOTFS_SIZE = "1000000"
IMAGE_FEATURES += "read-only-rootfs"
IMAGE_FSTYPES = "wic.bz2"
NOISO = "0"
NOHDD = "1"
WKS_FILE = "sika.wks"
