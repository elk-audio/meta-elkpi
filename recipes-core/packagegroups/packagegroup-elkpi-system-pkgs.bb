SUMMARY = "Packagegroup for system packages needed for the Elk Pi"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

RDEPENDS_packagegroup-elkpi-system-pkgs = "\
    elkpi-systemd-services \
    swupdate \
    swupdate-client \
    swupdate-www \
    elkpi-blackboard \
"