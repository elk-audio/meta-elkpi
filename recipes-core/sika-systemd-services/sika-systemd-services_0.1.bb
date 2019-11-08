DESCRIPTION = "All custom systemd services for the Sika board"
LICENSE = "CLOSED"
PR = "r0"
PN = "sika-systemd-services"
PV = "0.1"
S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit systemd

FILES_${PN} += "${systemd_system_unitdir}/*"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

SRC_URI += "file://sushi.service \
            file://sensei.service"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/sushi.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/sensei.service ${D}${systemd_system_unitdir}/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES += "${PN}"
SYSTEMD_SERVICE_${PN} += "sushi.service \
                          sensei.service"
SYSTEMD_AUTO_ENABLE = "disable"
