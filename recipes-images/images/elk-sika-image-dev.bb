DESCRIPTION = "Elk Linux development image for Sika"

LICENSE = "GPLv2"
require recipes-core/images/core-image-minimal-dev.bb
require elk-sika-common.inc
inherit populate_sdk_qt5

IMAGE_INSTALL += "packagegroup-elk-devtools \
                  packagegroup-elk-python-pkgs \
                  packagegroup-elk-audio-extra \
                  packagegroup-elk-qt-pkgs \
                  mda-vst2-plugins \
                  mda-vst3-plugins"

EXTRA_IMAGE_FEATURES += " ssh-server-openssh package-management"
IMAGE_ROOTFS_SIZE = "2000000"
SDIMG_ROOTFS_TYPE = "ext4"
IMAGE_FSTYPES = "wic ext4.gz"
NOISO = "0"
NOHDD = "1"
WKS_FILE = "sika.wks"

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
