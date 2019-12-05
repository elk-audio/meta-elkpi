SYSTEMD_DEFAULT_TARGET = "custom-elk.target"
IMAGE_FEATURES += "package-management"

IMAGE_LINGUAS += "en-us"

IMAGE_INSTALL += " \
    packagegroup-elk-libs-basic \
    packagegroup-elk-system-basic \
    packagegroup-elk-applications \
    packagegroup-elk-raspberrypi-system-pkgs \
    packagegroup-elk-sika-apps-basic \
    packagegroup-elk-sika-system-pkgs \
"

IMAGE_INSTALL_remove = " dropbear"
IMAGE_INSTALL_append = " glibc-utils localedef"
IMAGE_LINGUAS += "en-us"

ROOTFS_POSTPROCESS_COMMAND += "set_special_permissions; "

set_special_permissions () {
    chown -R mind ${IMAGE_ROOTFS}/home/mind
    chgrp -R mind ${IMAGE_ROOTFS}/home/mind
}

ROOTFS_POSTPROCESS_COMMAND += "set_sudo_permissions; "

set_sudo_permissions () {
    # Give sudo permission for users
    sed -i 's/# %sudo/%sudo/' ${IMAGE_ROOTFS}/etc/sudoers
}

do_wic_image_prepare() {
#    echo "mtools_skip_check=1" >> ~/.mtoolsrc
    cp ${DEPLOY_DIR_IMAGE}/Image ${DEPLOY_DIR_IMAGE}/Image0
    cp ${DEPLOY_DIR_IMAGE}/Image ${DEPLOY_DIR_IMAGE}/Image1
    wic rm ${DEPLOY_DIR_IMAGE}/elk-sika-image-dev-raspberrypi3-64.wic:1/Image
    wic cp ${DEPLOY_DIR_IMAGE}/Image0 ${DEPLOY_DIR_IMAGE}/elk-sika-image-dev-raspberrypi3-64.wic:1
    wic cp ${DEPLOY_DIR_IMAGE}/Image1 ${DEPLOY_DIR_IMAGE}/elk-sika-image-dev-raspberrypi3-64.wic:1
    bzip2 -c ${DEPLOY_DIR_IMAGE}/elk-sika-image-dev-raspberrypi3-64.wic > ${DEPLOY_DIR_IMAGE}/elk-sika-image-dev-raspberrypi3-64.wic.bz2
    rm ${DEPLOY_DIR_IMAGE}/elk-sika-image-dev-raspberrypi3-64.wic
}

addtask wic_image_prepare after do_image_complete before do_rm_work