using System;
namespace MyFirstWebApplication.Models
{
	/// <summary>
	/// Прогноз погоды
	/// </summary>
	public class WeatherForecast
	{
		/// <summary>
		/// Дата измерения
		/// </summary>
		public DateTime Date { get; set; }

		/// <summary>
		/// Температура по Цельсию
		/// </summary>
		public int TemperatureC { get; set; }

		public int TemperatureF
		{
			get { return 32 + (int)(TemperatureC * 5 / 9); }
		}
	}
}

