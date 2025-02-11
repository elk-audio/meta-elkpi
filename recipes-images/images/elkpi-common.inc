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

# SDK gRPC and protobuf support
TOOLCHAIN_HOST_TASK += "\
    nativesdk-grpc \
    nativesdk-grpc-dev \
"
TOOLCHAIN_TARGET_TASK += "protobuf-staticdev"

# Set permissions for mind user for home/mind
set_special_permissions () {
    chown -R mind ${IMAGE_ROOTFS}/home/mind
    chgrp -R mind ${IMAGE_ROOTFS}/home/mind
}

ROOTFS_POSTPROCESS_COMMAND += "set_special_permissions; "

IMAGE_CMD:wic:append () {
    wic cp ${DEPLOY_DIR_IMAGE}/${BOOTFILES_DIR_NAME}/cmdline.txt ${IMGDEPLOYDIR}/${IMAGE_NAME}.wic:1

    #change perm on first boot service condition file in udata
    echo "change_perms" > ${DEPLOY_DIR_IMAGE}/change_perms
    wic cp ${DEPLOY_DIR_IMAGE}/change_perms ${IMGDEPLOYDIR}/${IMAGE_NAME}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/change_perms
}

compress_image () {
    bzip2 -c ${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.wic > ${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.wic.bz2
}

IMAGE_POSTPROCESS_COMMAND += "compress_image"

# Avoid appending .rootfs to the image file name
IMAGE_NAME_SUFFIX = ""

# Add version to image name
IMAGE_LINK_NAME:append = "-v${SWU_VERSION}"
SDK_VERSION = "v${SWU_VERSION}"
