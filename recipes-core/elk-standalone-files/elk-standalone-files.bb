# Recipe created by recipetool
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://git@bitbucket.org/mindswteam/elk-standalone-home.git;protocol=ssh;branch=develop"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "4358ef541e25f3cd1597f9d45088e4d2a6859c77"

MIND_HOME_DIR = "/home/mind"
S = "${WORKDIR}/git"

do_install () {
    install -d ${D}${MIND_HOME_DIR}
    cp -r ${S}/config_files ${D}${MIND_HOME_DIR}
}

FILES_${PN} += "${MIND_HOME_DIR}"
FILES_${PN} += "${MIND_HOME_DIR}/*"