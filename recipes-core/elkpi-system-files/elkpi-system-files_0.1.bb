SUMMARY = "System files and startup scripts for the ElkPi board"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://connect-midi-apps \
    file://elk_system_utils \
    file://elk-system.conf \
"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -m 0755 ${WORKDIR}/connect-midi-apps ${D}${bindir}
    install -m 0755 ${WORKDIR}/elk-system.conf ${D}${sysconfdir}
    install -m 0755 ${WORKDIR}/elk_system_utils ${D}${bindir}
}

FILES:${PN} = "${bindir}*"
FILES:${PN} += "${sysconfdir}*"

RDEPENDS:${PN} = "bash"
