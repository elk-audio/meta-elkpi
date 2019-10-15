# Recipe created by recipetool
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://git@bitbucket.org/mindswteam/elk-standalone-home.git;protocol=ssh;branch=develop"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "0723bf6865d3abb6631da9451296b9d09835332a"

MIND_HOME_DIR = "/home/mind"
S = "${WORKDIR}/git"

do_install () {
    install -d ${D}${MIND_HOME_DIR}
    cp -r ${S}/config_files ${D}${MIND_HOME_DIR}
}

FILES_${PN} += "${MIND_HOME_DIR}"
FILES_${PN} += "${MIND_HOME_DIR}/*"