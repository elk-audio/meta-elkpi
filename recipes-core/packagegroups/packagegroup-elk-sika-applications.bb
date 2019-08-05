SUMMARY = "Package group for packages needed by Sika"

inherit packagegroup

RDEPENDS_packagegroup-elk-sika-applications = " \
    elk-standalone-files \
    elk-startup-scripts \
    pi-bluetooth \
    pi-blaster \
    python-rtimu \
    python-sense-hat \
    rpi-gpio \
    rpio \
    raspi-gpio \
    wiringpi \
    "
