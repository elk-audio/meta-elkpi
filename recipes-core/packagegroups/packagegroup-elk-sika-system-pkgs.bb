SUMMARY = "System packages needed by Sika"

inherit packagegroup

RDEPENDS_packagegroup-elk-sika-system-pkgs = " \
    sika-systemd-services \
    swupdate \
    swupdate-client \
    udev-rules-rpi \
    crda \
    iw \
    wpa-supplicant \
    fw_utils \
    "
