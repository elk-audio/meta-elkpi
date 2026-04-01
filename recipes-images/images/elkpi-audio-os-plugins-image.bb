SUMMARY = "Elk Pi full image with third-party open-source audio plugins"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

require recipes-images/images/elkpi-audio-os-image.bb

IMAGE_INSTALL:append = " packagegroup-elk-audio-plugins"
