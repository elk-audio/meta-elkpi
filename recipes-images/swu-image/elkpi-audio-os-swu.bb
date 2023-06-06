SUMMARY = "Full development SWU for Elk Pi which contains all packages"

LICENSE = "CLOSED"

SRC_URI = "\
    file://sw-description \
"

IMAGE_LINK_NAME:append = "-v${SWU_VERSION}"

TARGET_IMAGE_NAME = "elkpi-audio-os-image"
TARGET_IMAGE_FILE_NAME = "${TARGET_IMAGE_NAME}-${MACHINE}-v${SWU_VERSION}.ext4.gz"

IMAGE_DEPENDS = "${TARGET_IMAGE_NAME}"
SWUPDATE_IMAGES = "${TARGET_IMAGE_FILE_NAME}"

inherit swupdate
