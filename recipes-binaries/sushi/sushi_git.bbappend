# Specific commit and build options of raspa for Elk Pi boards

# Remove github URI and point to bitbucket
SRC_URI:remove = "gitsm://github.com/elk-audio/sushi;protocol=https;nobranch=1"
SRC_URI:append = "gitsm://git@bitbucket.org/mindswteam/sushi.git;protocol=ssh;nobranch=1"
