import socket 

def create_socket(ip, port):
    sock = socket.socket()
    sock.bind((ip,port))
    sock.listen(5)
    return sock

def connect(sock):
    s, address = sock.accept()
    return s, address

def send(s, text):
    s.send(bytes(text + "\n", "utf-8"))

def recv(s, buffer):
    return s.recv(buffer).decode("utf-8")

sock = create_socket("10.9.72.178",4422)
client, address = connect(sock)

lol = recv(client, 16)
send(client, "nice job")
print(lol)