# Sushi recipe append:
# - Override SUPPORTED_BUFFER_SIZES
# - Add elk-pi supported sushi examples

# Define supported buffer size for this board
SUPPORTED_BUFFER_SIZES = "32 64 128"

# Add examples and sound files
CONFIG_FILES_DIR = "/home/mind/config_files"
SOUND_FILES_DIR = "/home/mind/soundfiles"

CONFIG_FILES = "\
    arp_peakmeter_osc_broadcast.json \
    cv_to_synth.json \
    empty.json \
    freeverb_aux.json \
    fx.json \
    multi_track.json \
    play_arp_mda_link.json \
    play_brickworks_fx.json \
    play_brickworks_synth.json \
    play_lv2.json \
    play_master_gain.json \
    play_vst2.json \
    play_vst3.json \
    prepost_tracks.json \
    rt_midi.json \
    send_return_seq.json \
"

do_install:append() {
    install -d ${D}${CONFIG_FILES_DIR}
    install -d ${D}${SOUND_FILES_DIR}
    for file in ${CONFIG_FILES};
    do
        install -m 0644 ${WORKDIR}/git/misc/config_files/${file} ${D}${CONFIG_FILES_DIR}/${file}
    done
    install -m 0644 ${WORKDIR}/git/misc/soundfiles/* ${D}${SOUND_FILES_DIR}/
}

FILES:${PN} += "${CONFIG_FILES_DIR}"
FILES:${PN} += "${CONFIG_FILES_DIR}/*"
FILES:${PN} += "${SOUND_FILES_DIR}"
FILES:${PN} += "${SOUND_FILES_DIR}/*"
