db.createUser(
    {
        user: "camilafetecua",
        pwd: "camila9803",
        roles: [
            {
                role: "readWrite",
                db: "docker"
            }
        ]
    }
)