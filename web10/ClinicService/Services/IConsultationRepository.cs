using ClinicService.Models;

namespace ClinicService.Services
{
    public interface IConsultationRepository : IRepository<Consultation, int>
	{
        IList<Consultation> GetByClientId(int clientId);
        IList<Consultation> GetByPetId(int petId);
    }
}

