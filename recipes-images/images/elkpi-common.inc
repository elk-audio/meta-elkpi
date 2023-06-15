SYSTEMD_DEFAULT_TARGET = "custom-elk.target"

IMAGE_LINGUAS += "en-us"

IMAGE_INSTALL += "\
    packagegroup-elk-applications \
    packagegroup-elk-libs-basic \
    packagegroup-elk-system-basic \
    packagegroup-elk-raspberrypi-system-pkgs \
    packagegroup-elkpi-apps-basic \
    packagegroup-elkpi-system-basic-pkgs \
    packagegroup-elk-python-basic \
    packagegroup-elk-image-testing \
"

IMAGE_INSTALL:remove = " dropbear"

TOOLCHAIN_HOST_TASK += "\
    nativesdk-grpc \
    nativesdk-grpc-dev \
"

# Set permissions for mind user for home/mind
set_special_permissions () {
    chown -R mind ${IMAGE_ROOTFS}/home/mind
    chgrp -R mind ${IMAGE_ROOTFS}/home/mind
}

ROOTFS_POSTPROCESS_COMMAND += "set_special_permissions; "

# Function which prerares the dual rootfs and udata partitions for the final image
do_wic_image_prepare() {
    wic cp ${DEPLOY_DIR_IMAGE}/${BOOTFILES_DIR_NAME}/cmdline.txt ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.wic:1
    #change perm on first boot service condition file in udata
    echo "change_perms" > ${DEPLOY_DIR_IMAGE}/change_perms
    wic cp ${DEPLOY_DIR_IMAGE}/change_perms ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/change_perms

    bzip2 -c ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.wic > ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.wic.bz2
}

addtask wic_image_prepare after do_image_complete before do_rm_work

IMAGE_LINK_NAME:append = "-v${SWU_VERSION}"
