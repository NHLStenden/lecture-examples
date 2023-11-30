using System;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace Sockets;

public partial class MainPage : ContentPage
{
    int count = 0;

    public MainPage()
    {
        InitializeComponent();
    }

    private void Send_OnClicked(object sender, EventArgs e)
    {
        Editor request = FindByName("request") as Editor;
        Label response = FindByName("response") as Label;
		response.Text = SendMessage(Encoding.ASCII.GetBytes(request.Text));
    }

	private string SendMessage(byte[] payload) {
		try {
			IPAddress addr = IPAddress.Parse("127.0.0.1");
			IPEndPoint endpoint = new IPEndPoint(addr, 8080);

			Socket socket = new Socket(addr.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
			socket.Connect(endpoint);
			Console.WriteLine("Connected");

			socket.Send(payload);
			
			byte[] receivedMsg = new byte[1024];
			int msgSize = socket.Receive(receivedMsg);

			socket.Shutdown(SocketShutdown.Both);
			socket.Close();
			return Encoding.ASCII.GetString(receivedMsg, 0, msgSize);
		} catch (Exception e) {
			Console.WriteLine(e.ToString());
		}
		return "";
	}
}