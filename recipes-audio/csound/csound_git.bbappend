# Append for csound
# Set cortex-a72 specific settings

OECMAKE_C_FLAGS_RELEASE += " -mtune=cortex-a72"
OECMAKE_CXX_FLAGS_RELEASE += " -mtune=cortex-a72"
