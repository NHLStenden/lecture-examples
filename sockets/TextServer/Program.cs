using System;
using System.Net;
using System.Net.Sockets;
using System.Text;

class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Server aan het opzetten op tcp://127.0.0.1:8080");

        while (true)
        {
            StartTextServer();
            Console.WriteLine("Er wat net iemand verbonden.");
        }
    }

    public static void StartTextServer()
    {
        IPAddress addr = IPAddress.Parse("127.0.0.1");
        IPEndPoint endPoint = new IPEndPoint(addr, 8080);

        Socket listener = new Socket(addr.AddressFamily, SocketType.Stream, ProtocolType.Tcp);

        try {
            listener.Bind(endPoint);
            listener.Listen(10);

            Socket socket = listener.Accept();
            byte[] buffer = new byte[1024];
            int msgSize = socket.Receive(buffer);

            string response = "Hallo, ";
            response += Encoding.ASCII.GetString(buffer, 0, msgSize);
            socket.Send(Encoding.ASCII.GetBytes(response));
            socket.Shutdown(SocketShutdown.Both);
            socket.Close();
        } catch (Exception e) {
            Console.WriteLine(e.ToString());
        }
    }
}