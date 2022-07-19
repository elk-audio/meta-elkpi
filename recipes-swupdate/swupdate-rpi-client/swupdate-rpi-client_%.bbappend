FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "\
    file://swupdate-rpi-client \
    file://notify-swupdate-start \
"

do_install:append() {
    echo "${SWU_VERSION}" >>${WORKDIR}/sw_version
    install -d ${D}/www
    install -m 0755 ${WORKDIR}/swupdate-rpi-client ${D}${bindir}
    install -m 0755 ${WORKDIR}/notify-swupdate-start ${D}${bindir}
    install -m 0644 ${WORKDIR}/sw_version ${D}${sysconfdir}
    ln -s -r ${D}${sysconfdir}/sw_version ${D}/www/sw_version.txt
}

FILES:${PN} += "/www"

