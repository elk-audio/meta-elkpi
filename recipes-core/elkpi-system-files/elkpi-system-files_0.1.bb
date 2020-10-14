SUMMARY = "System files and startup scripts for the ElkPi board"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

ELK_HAT_NAME ?= "elkpi-stereo"

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
    sed -i '/AUDIO_HAT/c\AUDIO_HAT=${ELK_HAT_NAME}' ${D}${sysconfdir}/elk-system.conf
    install -m 0755 ${WORKDIR}/elk_system_utils ${D}${bindir}
}

FILES_${PN} = "${bindir}*"
FILES_${PN} += "${sysconfdir}*"

RDEPENDS_${PN} = "bash"
