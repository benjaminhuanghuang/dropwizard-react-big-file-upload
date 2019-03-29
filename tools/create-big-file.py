with open("bigfile.bin", "wb") as out:
    out.seek((1024 * 1024 * 1024) - 1)
    out.write('\0')