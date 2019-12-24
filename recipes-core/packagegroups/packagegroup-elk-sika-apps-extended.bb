SUMMARY = "Package group for packages needed by Sika"

inherit packagegroup

RDEPENDS_packagegroup-elk-sika-apps-extended = " \
    elkpi-user-files \
    pi-bluetooth \
    pi-blaster \
    python-rtimu \
    python-sense-hat \
    rpi-gpio \
    rpio \
    raspi-gpio \
    "
