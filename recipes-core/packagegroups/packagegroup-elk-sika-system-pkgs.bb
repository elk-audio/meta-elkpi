SUMMARY = "System packages needed by Sika"

inherit packagegroup

RDEPENDS_packagegroup-elk-sika-system-pkgs = " \
    sika-systemd-services \
    sw-version \
    udev-rules-rpi \
	crda \
	iw \
	wpa-supplicant \
    "
