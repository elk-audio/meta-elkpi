FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
    file://swupdate-client \
    file://sw_version \
    file://notify-swupdate-start \
"

do_install_append() {
    install -m 0755 ${WORKDIR}/swupdate-client ${D}${bindir}
    install -m 0755 ${WORKDIR}/notify-swupdate-start ${D}${bindir}
    install -m 0644 ${WORKDIR}/sw_version ${D}${sysconfdir}
}