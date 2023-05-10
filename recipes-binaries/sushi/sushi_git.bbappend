# Specific commit and build options of raspa for Elk Pi boards

# Remove github URI and point to bitbucket
SRC_URI:remove = "gitsm://github.com/elk-audio/sushi;protocol=https;nobranch=1"
SRC_URI:append = "gitsm://git@bitbucket.org/mindswteam/sushi.git;protocol=ssh;nobranch=1"

CONFIG_FILES_DIR = "/home/mind/config_files"

# List of supported sushi config files
CONFIG_FILES = "\
    arp_peakmeter_osc_broadcast.json \
    cv_to_synth.json \
    empty.json \
    fx.json \
    multi_track.json \
    play_arp_mda_link.json \
    play_lv2.json \
    play_master_gain.json \
    play_vst3.json \
    prepost_tracks.json \
    rt_midi.json \
    send_return_seq.json \
"

do_install:append() {
    install -d ${D}${CONFIG_FILES_DIR}
    for file in ${CONFIG_FILES};
    do
        install -m 0644 ${WORKDIR}/git/misc/config_files/${file} ${D}${CONFIG_FILES_DIR}/${file}
    done
}

FILES:${PN} += "${CONFIG_FILES_DIR}"
FILES:${PN} += "${CONFIG_FILES_DIR}/*"
