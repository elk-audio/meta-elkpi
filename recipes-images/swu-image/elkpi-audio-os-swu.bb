DESCRIPTION = "Recipe to build SWUpdate for Elk Audio OS"

LICENSE = "CLOSED"

DISTRO_VERSION = "${SWU_VERSION}"

SRC_URI = "\
    file://sw-description \
"

IMAGE_DEPENDS = "elkpi-audio-os-image"

SWUPDATE_IMAGES = "elkpi-audio-os-image"

SWUPDATE_IMAGES_FSTYPES[elkpi-audio-os-image] = ".ext4.gz"

inherit swupdate

