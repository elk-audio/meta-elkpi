SUMMARY = "Packagegroup for extended system packages needed for the Elk Pi"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

# elkpi-blackboard is not supported since it requires sensei
#RDEPENDS:packagegroup-elkpi-system-extended-pkgs = "\
#    elkpi-blackboard \
#"
