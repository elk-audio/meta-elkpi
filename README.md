# Meta Sika
### Recipes for the SIka board based on the RaspberryPi 3

Contains necessary packages, services and firmware binaries for Sika. To build, execute as follows:

 - TEMPLATECONF=./meta-sika/conf source layers/oe-init-build-env
 - To build dev image : `bitbake elk-sika-image-dev`
 - To build production image : `bitbake elk-sika-image`
 - Output image type is a sdcard image with extension \<image\>.rpi-sdimg.bz2. To flash it to a sdcard use command
    `bzcat <image>.rpi-sdimg.bz2 | sudo dd of=/dev/<device> bs=1M status=progress && sync`