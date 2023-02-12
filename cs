#client
import socket


def client_program():
    host =  socket.gethostname()  # as both code is running on same pc
    port = 9996 # socket server port number

    client_socket = socket.socket()  # instantiate
    client_socket.connect((host, port))  # connect to the server

    data = input("Get mac from server or post to server(enter either get or post)")  # take input
    client_socket.send(data.encode('utf-8'))
    
    if(data=="get"):
        ipadd = input("Enter the ip address")
        client_socket.send(ipadd.encode('utf-8'))  # send message
        #data = client_socket.recv(1024).decode()  # receive response
        mac_add = client_socket.recv(1024).decode('utf8')  # receive response
        print(mac_add);
    elif(data=="post"):
        ipadd = input("Enter the ip address")
        client_socket.send(ipadd.encode('utf-8'))  # send message
        macadd = input("Enter the mac address")
        client_socket.send(macadd.encode('utf-8'))  # send message
        mac_ip = client_socket.recv(1024).decode('utf8')
        print(mac_ip);
    else:
        print("enter either get or post")
    client_socket.close()  # close the connection


if __name__ == '__main__':
    client_program()


#server
import socket


def server_program():
    mac_table = {
   "192.168.127.1": "00:0C:42:A9:95:8B",
   "192.168.127.3": "10:93:E9:09:50:04",
   "192.168.127.34": "18:B4:30:05:CA:3C",
   "192.168.127.13": "28:CF:DA:05:5F:99",
   "192.168.2.1" : "3C:07:54:09:EC:CD" 
   }
    # get the hostname
    host = socket.gethostname()
    port = 9996  # initiate port no above 1024

    server_socket = socket.socket()  # get instance
    # look closely. The bind() function takes tuple as argument
    server_socket.bind((host, port))  # bind host address and port together

    # configure how many client the server can listen simultaneously
    server_socket.listen(2)
    conn, address = server_socket.accept()  # accept new connection
    print("Connection from: " + str(address))
    i = 1;
    while i==1:
        print('Connected to server')
        # receive data stream. it won't accept data packet greater than 1024 bytes
        
        data = conn.recv(1024).decode('utf8')
        if data == 'get':
            ipadd = conn.recv(1024).decode('utf8')
            mac_add = mac_table[ipadd]
            conn.send(mac_add.encode('utf-8'))  # send data to the client
            i=i+1
        elif data == 'post':
            ipadd = conn.recv(1024).decode('utf8')
            macadd = conn.recv(1024).decode('utf8')
            mac_table[ipadd] = macadd
            print(mac_table)
            i=i+1
        else:
            print("enter either get or post")
            conn.close()
            i=i+1
        

    conn.close()  # close the connection


if __name__ == '__main__':
    server_program()
