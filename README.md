# meta-elkpi

OpenEmbedded/Yocto Project layer which forms the final product layer for
 creating the Elk Audio OS Image for the ElkPi Development Kits based on the
 RaspberryPi 3B+ or 3B.

Contains the necessary packages, services, firmware binaries and image recipes
 specific to the ElkPi Development Kit.

This acts as the **product** layer whose role is to
add further customization of recipes in
 [meta-elk](https://github.com/elk-audio/meta-elk) and
 [meta-raspberry-elk](https://github.com/elk-audio/meta-raspberrypi-elk) to
 provide the necessary image for the ElkPi Development Kit.

The specific contributions of this layer are:

  * Selects the specific versions of [SUSHI](https://github.com/elk-audio/sushi),
    [SENSEI](https://github.com/elk-audio/sensei),
    [RASPA](https://github.com/elk-audio/raspa) and
    [TWINE](https://github.com/elk-audio/twine) and describes their build options.
  * Installs system and user files for ElkPi Development Kit.
  * Contains the recipes for the images.

## Images

The images provided by this layer are :

  * `elkpi-audio-os-image` : A full development Elk Audio OS image for the ElkPi
       Kit containing numerous packages and tools. Use this image to generate the
       cross-compiling Yocto SDK.
  * `elkpi-audio-os-image-basic` : A basic development Elk Audio OS image for the
     ElkPi Kit which contains a reduced subset of packages and tools compared
     to `elkpi-audio-os-image`.

## Compatible Machines
The layer can build the same image for both RaspberryPi 3 and RaspberryPi 4. By default, the local.conf sets `MACHINE = "raspberrypi3"`

To build for RaspberryPi4 set `MACHINE = "raspberrypi4-64"` in the local.conf.

## Dependencies

This layer depends on:

  * [meta-elk](https://github.com/elk-audio/meta-elk)
  * [meta-raspberry-elk](https://github.com/elk-audio/meta-raspberrypi-elk)
  * [poky](http://git.yoctoproject.org/cgit/cgit.cgi/poky/)
  * [meta-swupdate](https://github.com/sbabic/meta-swupdate)
  * [meta-openembedded](https://git.openembedded.org/meta-openembedded)

### VST2 Support

By default, mda-vst2 plugins are not installed in the image and SUSHI will not
have VST2 support enabled. If you have access to the VST2 SDK you can enable
both by setting the variable `VST2SDK_PATH` in the `local.conf` file to the
path of the vst2 sdk as follows:

`VST2SDK_PATH = "path/to/the/vst2sdk/in/your/build/machine/"`

For example : `VST2SDK_PATH = "/home/user/vstsdk2.4"`

To disable VST2 support, just define `VST2SDK_PATH` as an empty string.
---

# Creating a prodution Elk Audio OS Image for your device
The goal of this layer is to act as a template to describe and generate an
 image for a  **Elk Powered device**. You can easily customize the recipes
 in this layer and tailor them to your needs.

## Adding files to the image

You can add your custom files (plugin binaries, scripts, samples etc) by
 modifying the
 [elkpi-user-files](recipes-core/elkpi-user-files/elkpi-user-files_0.1.bb) recipe:

  * Add any new files in the [files](recipes-core/elkpi-user-files/files)
    directory and add the new file to the list of sources in the recipe:

```
SRC_URI += "file://your_new_file"
```

  * Add the following line to the `do_install` task to specify where the files should
    be installed:

```
cp -r ${WORKDIR}/your_new_file ${D}path_in_image_rootfs
```
 
## Enabling SUSHI and SENSEI automatic startup

You can enable and customize the automatic startup of SUSHI and SENSEI in the
 image by modifying the recipe
 [elkpi-systemd-services](recipes-core/elkpi-systemd-services/elkpi-systemd-services_0.1.bb):

  * Modify [sushi.service](recipes-core/elkpi-systemd-services/files/sushi.service)
    and [sensei.service](recipes-core/elkpi-systemd-services/files/sensei.service)
    with your desired command-line arguments and config files.
  * If you want any automatic USB MIDI keyboard detection at startup, you can modify
    the [connect-midi-apps](recipes-core/elkpi-system-files/files/connect-midi-apps)
    script to your needs.
  * Replace the last line in the recipe
    [elkpi-systemd-services](recipes-core/elkpi-systemd-services/elkpi-systemd-services_0.1.bb)
    with the following:

 ```
 SYSTEMD_AUTO_ENABLE = "enable"
 ```

## Read-Only File System

You can enable an image to have a read-only root file system by adding the following line to an image recipe:

```
IMAGE_FEATURES += "read-only-rootfs"
```

## Adding new packages

You can add new packages to the image in two ways. Usually, OpenEmbedded contains recipes for many packages as standard and you can check if your package is part of the standard list [here](https://layers.openembedded.org/layerindex/branch/warrior/recipes/). If it is not part of OpenEmbedded's list, then you may need to write your own.

Then you can add the desired recipes to any of the [packagegroups](recipes-core/packagegroups) in this layer.

---
Copyright 2017-2023 Elk Audio AB, Stockholm, Sweden.
