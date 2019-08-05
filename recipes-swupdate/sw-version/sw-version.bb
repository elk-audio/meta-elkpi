# A temporary recipe put in place until sw update has been added to pilot
DESCRIPTION = "Recipe for installing sw version info file"
SECTION = "misc"
LICENSE = "CLOSED"

SRC_URI = "file://sw_version"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/sw_version ${D}${sysconfdir}
}

FILES_${PN} += "${sysconfdir}/*"