# Product layer kernel commandline append

CMDLINE:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'evl', 'isolcpus=2-3 evl.oobcpus=2-3', 'xenomai.allowed_group=2004', d)}"
