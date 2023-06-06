SUMMARY = "All custom systemd services for the ElkPi board"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PN = "elkpi-systemd-services"

SRC_URI += "\
    file://sushi.service \
    file://sensei.service \
    file://midi-connections.service \
"

S = "${WORKDIR}"

inherit systemd

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/sushi.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/sensei.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/midi-connections.service ${D}${systemd_system_unitdir}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES += "${PN}"

# Sensei service was removed from this list since sensei is not currently supported
# on EVL based images because underlying driver is not implemented.
SYSTEMD_SERVICE:${PN} += "\
    sushi.service \
    midi-connections.service \
"

FILES:${PN} += "${systemd_system_unitdir}/*"

# To enable it replace disable with enable.
SYSTEMD_AUTO_ENABLE = "disable"
