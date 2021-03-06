SYSTEMD_DEFAULT_TARGET = "custom-elk.target"
IMAGE_FEATURES += "package-management"

IMAGE_LINGUAS += "en-us"

IMAGE_INSTALL += "\
    glibc-utils \
    localedef \
    packagegroup-elk-libs-basic \
    packagegroup-elk-system-basic \
    packagegroup-elk-applications \
    packagegroup-elk-raspberrypi-system-pkgs \
    packagegroup-elkpi-apps-basic \
    packagegroup-elkpi-system-pkgs \
"

IMAGE_INSTALL_remove = " dropbear"

# Set permissions for mind user for home/mind
set_special_permissions () {
    chown -R mind ${IMAGE_ROOTFS}/home/mind
    chgrp -R mind ${IMAGE_ROOTFS}/home/mind
}

ROOTFS_POSTPROCESS_COMMAND += "set_special_permissions; "

# set sudo permisions fr mind user.
set_sudo_permissions () {
    # Give sudo permission for users
    sed -i 's/# %sudo/%sudo/' ${IMAGE_ROOTFS}/etc/sudoers
}

ROOTFS_POSTPROCESS_COMMAND += "set_sudo_permissions; "

# Function which prerares the dual rootfs and udata partitions for the final image
do_wic_image_prepare() {
    sed -i 's/console=serial0,115200/console=${SERIAL_CONSOLES}/' ${DEPLOY_DIR_IMAGE}/bcm2835-bootfiles/cmdline.txt
    wic cp ${DEPLOY_DIR_IMAGE}/bcm2835-bootfiles/cmdline.txt ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.wic:1
    #change perm on first boot service condition file in udata
    echo "change_perms" > ${DEPLOY_DIR_IMAGE}/change_perms
    wic cp ${DEPLOY_DIR_IMAGE}/change_perms ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/change_perms

    bzip2 -c ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.wic > ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.wic.bz2
    rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.wic
}

addtask wic_image_prepare after do_image_complete before do_rm_work
