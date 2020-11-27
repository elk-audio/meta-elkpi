SUMMARY = "Install Elk BlackBoard related files in the system"
HOMEPAGE = "https://github.com/elk-audio/elk-examples"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "git://github.com/elk-audio/elk-examples;protocol=https;nobranch=1"

SRCREV = "5518ebe82f59a348fdc4d180756ed90f5c00e71e"

S = "${WORKDIR}/git/blackboard/common-files"

inherit python3-dir

SENSEI_CONFIG_DIR = "${datadir}/sensei"
FONTS_DIR = "${datadir}/fonts/ttf"

do_install() {
    install -d ${D}${SENSEI_CONFIG_DIR}
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}

    install -m 0644 sensei_config.json ${D}${SENSEI_CONFIG_DIR}/blackboard.json
    install -m 0644 elk_ui.py ${D}${PYTHON_SITEPACKAGES_DIR}/
}

FILES_${PN} += "\
    ${SENSEI_CONFIG_DIR} \
    ${SENSEI_CONFIG_DIR}/* \
    ${PYTHON_SITEPACKAGES_DIR}/* \
"

RDEPENDS_${PN} += " liberation-fonts"

