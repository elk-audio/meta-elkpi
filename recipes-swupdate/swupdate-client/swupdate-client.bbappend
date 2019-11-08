DESCRIPTION = "Recipe for installing Rocket specific sw update files"
SECTION = "misc"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://swupdate-client \
	    file://sw_version"

do_install_append() {
    install -m 0755 ${WORKDIR}/swupdate-client ${D}${bindir}
    install -m 0644 ${WORKDIR}/sw_version ${D}${sysconfdir}
}
