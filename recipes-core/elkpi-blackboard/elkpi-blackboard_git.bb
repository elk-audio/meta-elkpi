SUMMARY = "Install Elk BlackBoard related files in the system"
HOMEPAGE = "https://github.com/elk-audio/elk-examples"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "git://github.com/elk-audio/elk-examples;protocol=https;nobranch=1"

SRCREV = "5518ebe82f59a348fdc4d180756ed90f5c00e71e"

S = "${WORKDIR}/git/blackboard/common-files"

SENSEI_CONFIG_DIR = "${datadir}/sensei"
FONTS_DIR = "${datadir}/fonts/ttf"
ELK_UI_DIR = "${libdir}/python3.7/site-packages/"

do_install() {
    install -d ${D}${SENSEI_CONFIG_DIR}
    install -d ${D}${FONTS_DIR}
    install -d ${D}${ELK_UI_DIR}

    install -m 0644 sensei_config.json ${D}${SENSEI_CONFIG_DIR}/blackboard.json
    install -m 0644 LiberationMono-Regular.ttf ${D}${FONTS_DIR}/
    install -m 0644 elk_ui.py ${D}${ELK_UI_DIR}/
}

FILES_${PN} += "\
    ${SENSEI_CONFIG_DIR} \
    ${SENSEI_CONFIG_DIR}/* \
    ${FONTS_DIR} \
    ${FONTS_DIR}/* \
    ${ELK_UI_DIR} \
    ${ELK_UI_DIR}/* \
"
