SUMMARY = "All custom systemd services for the ElkPi board"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI += "\
    file://sushi.service \
    file://midi-connections.service \
"

S = "${WORKDIR}"

PN = "elkpi-systemd-services"
SYSTEMD_PACKAGES += "${PN}"
SYSTEMD_SERVICE:${PN} += "\
    sushi.service \
    midi-connections.service \
"
# To enable it replace disable with enable.
SYSTEMD_AUTO_ENABLE = "disable"

inherit systemd

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/sushi.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/midi-connections.service ${D}${systemd_system_unitdir}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} += "${systemd_system_unitdir}/*"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
NATIVE_SYSTEMD_SUPPORT = "1"
