DESCRIPTION = "Recipe for installing system start-up scripts"
SECTION = "misc"
LICENSE = "CLOSED"

SRC_URI = " \
    file://load-drivers \
    file://change-udata-perms \
    "
RDEPENDS_${PN} = "bash"

do_install() {

  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/load-drivers ${D}${bindir}
  install -m 0755 ${WORKDIR}/change-udata-perms ${D}${bindir}
}

FILES_${PN} = "${bindir}*"
