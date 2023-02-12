def fragment_datagram(data, MTU_SIZE, ID, MF, DF, total_length, header_length):
    fragments = []
    offset = 0
    fragment_offset = 0
    chunk_size = 1024
    for i in range(0, len(data), chunk_size):
        chunk = data[i:i + chunk_size]
        while len(chunk) > 0:
            fragment_length = MTU_SIZE - header_length
            fragment = chunk[:fragment_length]
            if len(chunk) > fragment_length:
                MF = 1
            else:
                MF = 0
            fragment_offset = (fragment_offset + fragment_length) // 8
            fragments.append((fragment_offset, fragment, MF, DF, ID, total_length))
            chunk = chunk[fragment_length:]
            offset += fragment_length
    return fragments




def reassemble_datagram(fragments):
    data = b''
    for fragment in sorted(fragments, key=lambda x: x[0]):
        data += fragment[1]
    return data
