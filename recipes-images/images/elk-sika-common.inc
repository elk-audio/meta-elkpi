SYSTEMD_DEFAULT_TARGET = "custom-elk.target"
IMAGE_FEATURES += "package-management"

IMAGE_LINGUAS += "en-us"

IMAGE_INSTALL += " \
    packagegroup-elk-libs \
    packagegroup-elk-system-pkgs \
    packagegroup-elk-applications \
    packagegroup-elk-raspberrypi-system-pkgs \
    packagegroup-elk-sika-applications \
    packagegroup-elk-sika-system-pkgs \
"

IMAGE_INSTALL_remove = " dropbear"
IMAGE_INSTALL_append = " glibc-utils localedef"
IMAGE_LINGUAS += "en-us"
#IMAGE_FEATURES += "read-only-rootfs"

ROOTFS_POSTPROCESS_COMMAND += "set_special_permissions; "

set_special_permissions () {
    chown -R mind ${IMAGE_ROOTFS}/home/mind
    chgrp -R mind ${IMAGE_ROOTFS}/home/mind
}
