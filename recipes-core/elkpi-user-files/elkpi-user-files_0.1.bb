SUMMARY = "A collection of useful files and directories for user mind in elk-pi boards"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

# This is provided as a template. To add user files:
# - add them to the files directory (even using one single archive like in the example provided)
# - update SRC_URI
# - update the do_install function
# - add files to FILES:${PN}

#SRC_URI = "file://config_files.tar.gz"

MIND_HOME_DIR = "/home/mind"

do_install () {
    install -d ${D}${MIND_HOME_DIR}
    #cp -r ${WORKDIR}/config_files ${D}${MIND_HOME_DIR}
}

FILES:${PN} += "${MIND_HOME_DIR}"
FILES:${PN} += "${MIND_HOME_DIR}/*"
